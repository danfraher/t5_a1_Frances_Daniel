package com.example.t5_a1_frances_daniel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5_a1_frances_daniel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var comidaAdapter: ComidaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comidaAdapter = ComidaAdapter(getComida(), this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.rvComida.apply {

            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = comidaAdapter

        }

    }

    private fun getComida(): MutableList<Comida> {

        val comidaList = mutableListOf<Comida>()
        val pizza = Comida(1, "Pizza", "Italia", "https://www.creativefabrica.com/wp-content/uploads/2022/04/17/Pizza-Logo-Design-Graphics-29132095-3-580x387.jpg")
        val paella = Comida(2, "Paella", "España", "https://cdn-icons-png.flaticon.com/512/6824/6824038.png")
        val kebab = Comida(3, "Kebab", "Turquia", "https://img.freepik.com/vector-premium/ilustracion-vector-logotipo-kebab_518759-211.jpg?semt=ais_hybrid")
        val hamburguesa = Comida(4, "Hamburguesa", "Estados Unidos", "https://i.pinimg.com/474x/30/3c/d5/303cd5c4e2169130a9ddd90bfab76982.jpg")
        val pasta = Comida(5, "pasta", "Italia", "https://thumbs.dreamstime.com/b/spaghetti-pasta-minimalist-logo-illustration-elegant-stylish-design-spaghetti-pasta-minimalist-logo-illustration-elegant-327764135.jpg")

        comidaList.add(pizza)
        comidaList.add(paella)
        comidaList.add(kebab)
        comidaList.add(hamburguesa)
        comidaList.add(pasta)

        return comidaList

    }

    override fun onClick(user: Comida) {
        val comidaId = user.id

        val url = getWikipediaUrl(comidaId)
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)

    }

    private fun getWikipediaUrl(comidaId: Int): String {

        return when (comidaId) {

            1 -> "https://es.wikipedia.org/wiki/Pizza"
            2 -> "https://es.wikipedia.org/wiki/Paella"
            3 -> "https://es.wikipedia.org/wiki/Kebab"
            4 -> "https://es.wikipedia.org/wiki/Hamburguesa"
            5 -> "https://es.wikipedia.org/wiki/Pasta"
            else -> return "https://es.wikipedia.org/wiki/Pizza"

        }

    }

}