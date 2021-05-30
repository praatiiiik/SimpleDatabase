package com.example.todo_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RclrAdapter (private val context: Context , val listener : RclrClicked) : RecyclerView.Adapter<RclrAdapter.noteViewHolder>() {

    private val allNotes = ArrayList<EntityClass>()

    inner class noteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView1 = itemView.findViewById<TextView>(R.id.rclrTextView1)
        val textView2 = itemView.findViewById<TextView>(R.id.rclrTextView2)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.rclrButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {

        val viewHolder = noteViewHolder(LayoutInflater.from(context).inflate(R.layout.rclrvie,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.itemClicked(allNotes[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {

        val currentNotes = allNotes[position]
        holder.textView1.text = currentNotes.name
        holder.textView2.text = currentNotes.desig
    }

    override fun getItemCount(): Int {

        return allNotes.size
    }

    fun updateList(newList: List<EntityClass>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }

}

interface RclrClicked {
    fun itemClicked(notes:EntityClass)
}