package test.test.apimarveltest.view.listCharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import test.test.apimarveltest.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val viewModel by viewModels<CharacterListViewModel>()
    private lateinit var adapterCharacterList: AdapterCharacterList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        setListeners()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setListeners() {
        //TODO configure components
        viewModel.getListCharacter()
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