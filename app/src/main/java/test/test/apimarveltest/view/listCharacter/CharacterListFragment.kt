package test.test.apimarveltest.view.listCharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import test.test.apimarveltest.databinding.FragmentCharacterListBinding
import test.test.apimarveltest.view.details.CharacterDetailsViewModel
import test.test.apimarveltest.view.details.CharacterDetailsViewModelFactory

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private lateinit var adapterCharacterList: AdapterCharacterList
    private lateinit var  viewModel: CharacterListViewModel
    private lateinit var  viewModelFactory: CharacterListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        viewModelFactory = CharacterListViewModelFactory(context)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterListViewModel::class.java)

        viewModel.getListCharacter()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }


    private fun setObservers() {
        viewModel.characterLiveData.observe(viewLifecycleOwner, Observer {

            adapterCharacterList = AdapterCharacterList(it, this)

            binding.characterListRecyclerView.apply {
                adapter = adapterCharacterList
                adapterCharacterList.notifyDataSetChanged()
                layoutManager = LinearLayoutManager(activity)
            }
        })
    }
}