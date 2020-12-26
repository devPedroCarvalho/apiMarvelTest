package test.test.apimarveltest.view.listCharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import test.test.apimarveltest.MainActivity
import test.test.apimarveltest.databinding.FragmentCharacterListBinding
import test.test.apimarveltest.remoteDataSource.model.CharacterModel
import test.test.apimarveltest.remoteDataSource.model.DetailsModel
import test.test.apimarveltest.remoteDataSource.resource.Status
import test.test.apimarveltest.utils.showAlert

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private lateinit var adapterCharacterList: AdapterCharacterList
    private lateinit var  viewModel: CharacterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(CharacterListViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }


    private fun setObservers() {
        viewModel.getDetailsCharacter().observe(viewLifecycleOwner, Observer { it ->

            val listCharacter: MutableList<CharacterModel> = mutableListOf()

            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        if (resource.data?.isSuccessful == true){
                            resource.data.body()?.let {
                                for(results in it.data.results){
                                    val listCharacterModel = CharacterModel(
                                        id = results.id,
                                        name = results.name
                                    )
                                    listCharacter.add(listCharacterModel)

                                }
                                adapterCharacterList = AdapterCharacterList(listCharacter, this)
                                binding.characterListRecyclerView.apply {
                                    adapter = adapterCharacterList
                                    adapterCharacterList.notifyDataSetChanged()
                                    layoutManager = LinearLayoutManager(activity)
                                }
                            }
                        }else{
                            showAlert(activity,it.data?.message())
                        }
                    }
                    Status.ERROR -> {
                        hideProgressBar()
                        showAlert(activity,it.message)
                    }
                    Status.LOADING -> {
                       showProgressBar()

                    }
                }
            }
        })
    }

    private fun showProgressBar(){
        (requireActivity() as MainActivity).showProgressBar()
    }

    private fun hideProgressBar(){
        (requireActivity() as MainActivity).hideProgressBar()
    }
}