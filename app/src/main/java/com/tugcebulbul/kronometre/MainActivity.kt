package com.tugcebulbul.kronometre

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.tugcebulbul.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var kayitListesi = ArrayList<String>()
        var adapter = KayitAdapter(kayitListesi)
        binding.RvKaydedilen.adapter = adapter
        binding.RvKaydedilen.layoutManager = LinearLayoutManager(this)

        var zamaniDurdur:Long = 0
        binding.buttonBaslat.setOnClickListener {
            binding.buttonBaslat.visibility = View.GONE
            binding.buttonSifirla.visibility = View.GONE
            binding.buttonKaydet.visibility = View.VISIBLE
            binding.buttonDurdur.visibility = View.VISIBLE
            binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniDurdur
            binding.kronometre.start()

        }
        binding.buttonDurdur.setOnClickListener {
            binding.buttonBaslat.visibility = View.VISIBLE
            binding.buttonSifirla.visibility = View.VISIBLE
            binding.buttonKaydet.visibility = View.GONE
            binding.buttonDurdur.visibility = View.GONE
            zamaniDurdur = binding.kronometre.base - SystemClock.elapsedRealtime()
            binding.kronometre.stop()
        }

        binding.buttonSifirla.setOnClickListener{
            binding.buttonBaslat.visibility = View.VISIBLE
            binding.buttonSifirla.visibility = View.VISIBLE
            binding.buttonKaydet.visibility = View.GONE
            binding.buttonDurdur.visibility = View.GONE
            binding.kronometre.stop()
            zamaniDurdur = 0
            binding.kronometre.base = SystemClock.elapsedRealtime()
            kayitListesi.clear()
            adapter.notifyDataSetChanged()

        }
        binding.buttonKaydet.setOnClickListener{
            binding.buttonBaslat.visibility = View.GONE
            binding.buttonSifirla.visibility = View.GONE
            binding.buttonKaydet.visibility = View.VISIBLE
            binding.buttonDurdur.visibility = View.VISIBLE
           val kaydedilenSure = binding.kronometre.text.toString()
            kayitListesi.add(kaydedilenSure)
            adapter.notifyDataSetChanged()
        }

    }
}