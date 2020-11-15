package test.test.apimarveltest.view.details

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CharacterDetailsViewModelFactory(
        private val context: Context?
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CharacterDetailsViewModel::class.java)){
            return CharacterDetailsViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}