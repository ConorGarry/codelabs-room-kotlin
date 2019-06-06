package ie.conorgarry.codelabroomkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ie.conorgarry.codelabroomkotlin.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    interface Callback {
        fun onClick(view: View)
    }

    // Binding
    private lateinit var bind: ActivityNewWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_new_word)
        bind.callback = object : Callback {
            override fun onClick(view: View) {
                val replyIntent = Intent()
                if (TextUtils.isEmpty(bind.editWord.text)) {
                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val word = bind.editWord.text.toString()
                    replyIntent.putExtra(EXTRA_REPLY, word)
                    setResult(Activity.RESULT_OK, replyIntent)
                }
                finish()
            }
        }
    }
}

