package com.example.tayler_gabbi.michi.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tayler_gabbi.michi.R
import com.example.tayler_gabbi.michi.database.model.Puntaje
import kotlinx.android.synthetic.main.molde_lista_puntajes.view.*

class ListaPuntajesAdapter : RecyclerView.Adapter<ListaPuntajesAdapter.PuntajeViewHolder>(){

    private var puntajes : List<Puntaje>? = null

    fun addList(puntajes : List<Puntaje>){
        this.puntajes = puntajes

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuntajeViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.molde_lista_puntajes,parent,false)
        return PuntajeViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(puntajes){return 0}
        return checkedUser.size
    }


    override fun onBindViewHolder(holder: PuntajeViewHolder, position: Int) {
        val puntaje = puntajes!![position]

        holder.nombreProducto.text = puntaje.jugador
        holder.precioproducto.text =puntaje.puntaje.toString()

    }

    class PuntajeViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val nombreProducto = itemView.nombre_jugador
        val precioproducto = itemView.text_puntaje



    }
}