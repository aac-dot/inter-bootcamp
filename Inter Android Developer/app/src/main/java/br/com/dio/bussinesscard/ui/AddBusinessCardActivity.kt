package br.com.dio.bussinesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.bussinesscard.App
import br.com.dio.bussinesscard.MainViewModelFactory
import br.com.dio.bussinesscard.R
import br.com.dio.bussinesscard.data.BusinessCard
import br.com.dio.bussinesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmpresa.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )

            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_mostrar_sucesso, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}