package br.edu.ifsp.project

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        val queue: RequestQueue = Volley.newRequestQueue(this)
        val urlTexto = "http://10.105.68.96:8080/exemplo/texto"
        val stringRequest = StringRequest(
            Request.Method.GET, urlTexto,
            { response ->
        // Exibir o texto recebido
                textView.text = response
            },
            { error ->
                error.printStackTrace()
            })
        queue.add(stringRequest)
    }
}