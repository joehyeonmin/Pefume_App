package com.hyeon.tflite.tfliteimageclassifier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PerfumeAdapter(val profileList: ArrayList<Perfumes>) : RecyclerView.Adapter<PerfumeAdapter.CustomViewHolder>()
{
    // list_item을 가져와서 어뎁터에 붙이기
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfumeAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val profile : Perfumes = profileList.get(curPos)

                Toast.makeText(parent.context, "이름 : ${profile.name}\n가격 : ${profile.cost}\n냄새 : ${profile.scent}", Toast.LENGTH_SHORT).show()

                // 서브 액티비티로 인텐트 보내기
                //val intent = Intent(parent.context, SubActivity1::class.java)
                //intent.putExtra("msg1", profile.name)
                //intent.putExtra("msg2", profile.cost)
                //intent.putExtra("msg3", profile.scent)
                //parent.context.startActivity(intent)
            }
        }
    }

    override fun onBindViewHolder(holder: PerfumeAdapter.CustomViewHolder, position: Int) {
        holder.image.setImageResource(profileList.get(position).image)
        holder.name.text = profileList.get(position).name
        holder.cost.text = profileList.get(position).cost.toString()
        holder.scent.text = profileList.get(position).scent
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    // 내부클래스
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.iv_perfume) // 이미지
        val name = itemView.findViewById<TextView>(R.id.tv_name) // 이름
        val cost = itemView.findViewById<TextView>(R.id.tv_cost) // 가격
        val scent = itemView.findViewById<TextView>(R.id.tv_scent) // 냄새
    }
}