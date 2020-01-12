package kh.sergeimaleev.testtaskanoda

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kh.sergeimaleev.model.PostItem
import java.io.IOException
import java.lang.reflect.Type
import java.nio.charset.Charset

class HomeViewModel(
    private val app: Application
): AndroidViewModel(app) {
    val posts = MutableLiveData<List<PostItem>>()

    init {
        loadData()
    }

    private fun loadData(){
        loadJSONFromAsset()?.let {
            posts.value = getPostsFromJson(it)
        }
    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the object
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val stream = app.assets.open("document.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
           Log.d(this::class.java.name, ex.toString(), ex.fillInStackTrace())
        }
        return json
    }

    private fun getPostsFromJson(jsonData: String?): List<PostItem>{

        val type: Type = object : TypeToken<List<PostItem>>() {}.type
        val result: List<PostItem> = Gson().fromJson(jsonData, type)

        Log.d("posts", result.toString())
        return result
    }
}