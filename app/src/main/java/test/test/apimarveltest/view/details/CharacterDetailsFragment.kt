package test.test.apimarveltest.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import test.test.apimarveltest.MainActivity
import test.test.apimarveltest.R
import test.test.apimarveltest.databinding.FragmentCharacterDetailsBinding
import test.test.apimarveltest.remoteDataSource.model.DetailsModel
import test.test.apimarveltest.remoteDataSource.resource.Status
import test.test.apimarveltest.utils.loadImage
import test.test.apimarveltest.utils.showAlert

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: CharacterDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(CharacterDetailsViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setObservers() {

        val id = args.id

        viewModel.getDetailsCharacter(id).observe(viewLifecycleOwner, Observer {

            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideProgressBar()
                        if (resource.data?.isSuccessful == true){

                        resource.data.body().let {response->
                            val modelDetails = DetailsModel(
                                    name = response?.data?.results!![0].name,
                                    description = response.data.results[0].description,
                                    image = response.data.results[0].thumbnail.path,
                                    extension = response.data.results[0].thumbnail.extension
                            )

                            if (modelDetails.name.isBlank()){
                                binding.titleTextView.text = getString(R.string.title_is_empty)
                            }else{
                                binding.titleTextView.text = modelDetails.name
                            }
                            if (modelDetails.description.isBlank()){
                                binding.descriptionTextView.text = getString(R.string.description_is_empty)

                            }else{
                                binding.descriptionTextView.text = modelDetails.description

                            }
                            loadImage(modelDetails.url(),binding.imageCharacterImageView,this)
                        }
                        }else{
                            showAlert(activity,"ERROR:${it.data?.code()} ${it.data?.message()}")
                        }
                    }

                    Status.ERROR -> {
                        hideProgressBar()
                        showAlert(activity,"ERROR:${it.data?.code()} ${it.data?.message()}")
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