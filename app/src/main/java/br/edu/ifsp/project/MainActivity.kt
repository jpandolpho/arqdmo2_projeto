package br.edu.ifsp.project

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView: TextView = findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.imageView)

        val queue: RequestQueue = Volley.newRequestQueue(this)
        val urlTexto = "http://10.105.68.96:8080/exemplo/texto"
        val urlImagem = "http://10.105.68.96:8080/exemplo/imagem"

        val stringRequest = StringRequest(
            Request.Method.GET, urlTexto,
            { response ->
        // Exibir o texto recebido
                textView.text = response
            },
            { error ->
                error.printStackTrace()
            })
        val imageRequest = ImageRequest(urlImagem,
            { response ->
            // Exibir a imagem recebida
                imageView.setImageBitmap(response)
            },
            0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565,
            { error ->
                error.printStackTrace()
            })

        queue.add(stringRequest)
        queue.add(imageRequest)
    }
}