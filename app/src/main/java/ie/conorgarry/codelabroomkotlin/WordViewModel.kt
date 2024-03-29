package ie.conorgarry.codelabroomkotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    val allWords: LiveData<List<Word>>
    private val repo: WordRepository

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repo = WordRepository(wordsDao)
        allWords = repo.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repo.insert(word)
    }
}