package br.edu.ifsp.project

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import br.edu.ifsp.project.databinding.ActivityMainBinding
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configButton()
    }

    private fun configButton() {
        binding.buttonGerar.setOnClickListener {
            populate()
        }
    }

    private fun populate() {
        val queue: RequestQueue = Volley.newRequestQueue(this)
        val stringRequest = createRequestString()
        val imageRequest = createRequestImage()
        queue.add(stringRequest)
        queue.add(imageRequest)
    }

    private fun createRequestString(): StringRequest {
        val urlTexto = "http://10.105.68.96:8080/exemplo/texto"
        return StringRequest(
            Request.Method.GET, urlTexto,
            { response ->
                // Exibir o texto recebido
                binding.textView.text = response
            },
            { error ->
                error.printStackTrace()
            })
    }

    private fun createRequestImage() : ImageRequest{
        val urlImagem = "http://10.105.68.96:8080/exemplo/imagem"
        return ImageRequest(urlImagem,
            { response ->
                // Exibir a imagem recebida
                binding.imageView.setImageBitmap(response)
            },
            0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565,
            { error ->
                error.printStackTrace()
            })
    }
}