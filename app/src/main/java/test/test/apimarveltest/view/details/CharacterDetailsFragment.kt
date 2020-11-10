package test.test.apimarveltest.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import test.test.apimarveltest.R
import test.test.apimarveltest.databinding.FragmentCharacterDetailsBinding
import test.test.apimarveltest.view.listCharacter.CharacterListViewModel

class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding
    private val args: CharacterDetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<CharacterDetailsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        //setListeners()
        val teste = args.id
        print(teste)
        viewModel.getDetailsCharacter(teste)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    private fun setListeners() {
        //TODO configure components
    }

    private fun setObservers() {
        viewModel.detailsLiveData.observe(viewLifecycleOwner, Observer {

            binding.titleTextView.text = it.name
            binding.descriptionTextView.text = it.description

            Glide.with(this)
                .load(it.url())
                .into(binding.imageCharacterImageView)
        })
    }
}