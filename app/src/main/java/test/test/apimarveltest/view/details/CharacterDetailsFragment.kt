package test.test.apimarveltest.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import test.test.apimarveltest.R
import test.test.apimarveltest.databinding.FragmentCharacterDetailsBinding
import test.test.apimarveltest.utils.loadImage

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: CharacterDetailsViewModel
    private lateinit var  viewModelFactory: CharacterDetailsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)

        viewModelFactory = CharacterDetailsViewModelFactory(context)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterDetailsViewModel::class.java)

        val id = args.id
        viewModel.getDetailsCharacter(id)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        viewModel.detailsLiveData.observe(viewLifecycleOwner, Observer {


            if (it.name.isBlank()){
                binding.titleTextView.text = getString(R.string.title_is_empty)
            }else{
                binding.titleTextView.text = it.name
            }

            if (it.description.isBlank()){
                binding.descriptionTextView.text = getString(R.string.description_is_empty)

            }else{
                binding.descriptionTextView.text = it.description

            }
            loadImage(it.url(),binding.imageCharacterImageView,this)
        })
    }
}