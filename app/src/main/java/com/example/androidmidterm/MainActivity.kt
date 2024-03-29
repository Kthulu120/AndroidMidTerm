package com.example.androidmidterm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.androidmidterm.R
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Volley uses internet permissions which needs to be enabled in the AndroidManifest.xml
        val queue = Volley.newRequestQueue(this)

        // Random Number Endpoint
        val url = "http://vivid-memento-254504.appspot.com/"

        // OU calendar returns a Json Array, if your website returns a Json Object then use JsonObjectRequest
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // eventTitle is the id for the textbox in activity_main.xml
                eventTitle.text = "Random Number: ${response}"
            },
            Response.ErrorListener { response -> eventTitle.text = "${response}" })

        // button is the id for the button in activity_main.xml
        button.setOnClickListener {
            queue.add(stringRequest)
        }
    }
}
