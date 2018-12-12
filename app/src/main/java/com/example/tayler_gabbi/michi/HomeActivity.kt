package com.example.tayler_gabbi.michi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.tayler_gabbi.michi.database.model.Jugador
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.dialog_agregar_jugador.view.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import kotlin.concurrent.thread

class HomeActivity : AppCompatActivity() ,View.OnClickListener{


    var spiner1 : Spinner? = null
    var spiner2 : Spinner? = null
    var handler : Handler = Handler()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        spiner1 = findViewById(R.id.combo_jugador1)
        spiner2 = findViewById(R.id.combo_jugador2)

        btn_agregar_jugador.setOnClickListener(this)
        btn_iniciar_partida.setOnClickListener(this)
        btn_ver_puntaje.setOnClickListener(this)

        cargarSpiner()


    }


    override fun onClick(item: View?) {

        when(item){

            btn_agregar_jugador -> { agregarNuevoJugador()}

            btn_iniciar_partida -> { }

            btn_ver_puntaje -> startActivity<PuntajesActivity>()
        }
    }

    fun agregarNuevoJugador(){

        val dialogBuilder = AlertDialog.Builder(this@HomeActivity)
        val dialogView = layoutInflater.inflate(R.layout.dialog_agregar_jugador,null)

        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(true)

        val dialog = dialogBuilder.create()
        dialogView.btn_dialog_agregar.setOnClickListener{

            thread(start=true){

                if(!dialogView.edit_name_jugador.text.toString().isEmpty()){

                    val jugador = Jugador()
                    jugador.nombre = dialogView.edit_name_jugador.text.toString()

                    val nuevoId = MichiApplication.dataBase!!.jugadorDao().insert(jugador)

                    if (nuevoId != null && nuevoId > 0){
                        handler.post {
                            cargarSpiner()
                            toast("Jugador Agregado")
                            dialog.dismiss()
                        }

                    }else{
                        handler.post {
                            toast("Jugador No Agregado")
                            dialog.dismiss()
                        }

                    }

                }else{
                    toast("Ingrese Nombre")
                }

            }

        }


        dialog.show()
    }

    fun cargarSpiner(){


        thread(start=true) {

            val jugadores = ArrayList<String>()
            val lista = MichiApplication.dataBase!!.jugadorDao().listarJugador()

            lista.forEach {
                jugadores.add(it.nombre)
            }

            val adapter = ArrayAdapter<String>(this, R.layout.molde_spinner, jugadores)
            adapter.setDropDownViewResource(R.layout.molde_spinner)

            handler.post {

                spiner1!!.adapter = adapter
                spiner2!!.adapter = adapter

            }

        }
                spiner1!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                         val jugador1 = parent!!.getItemAtPosition(position).toString()
                        defaultSharedPreferences.edit().putString("jugador1",jugador1).apply()

                    }
                }

                spiner2!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val jugador2 = parent!!.getItemAtPosition(position).toString()
                        defaultSharedPreferences.edit().putString("jugador2",jugador2).apply()

                    }
                }

    }


}
