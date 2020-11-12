package test.test.apimarveltest.view.listCharacter

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CharacterListViewModelFactory(
        private val context: Context?
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterListViewModel::class.java)){
            return CharacterListViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}
