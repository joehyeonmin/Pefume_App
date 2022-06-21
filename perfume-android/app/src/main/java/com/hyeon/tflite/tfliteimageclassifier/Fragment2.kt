package com.hyeon.tflite.tfliteimageclassifier

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.room.Room


class Fragment2 : Fragment() {

    private val user_DataArray : ArrayList<Perfumes> = ArrayList()
    lateinit var View1 : TextView
    lateinit var button1 : Button

    private lateinit var db: UserDatabase

    lateinit var picture:Bitmap
    lateinit var name : String
    lateinit var cost : String
    lateinit var scent : String
    lateinit var memo : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_2, container, false)

        db = Room.databaseBuilder(
            requireActivity().applicationContext, UserDatabase::class.java, "user.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        View1 = rootView.findViewById(R.id.result_text!!)as TextView

        activity?.let {
            db.userDao().getAll().observe(it, Observer{
                updateUserList((it))
            })
        }

        /*db.userDao().getAll().observe(viewLifecycleOwner, Observer { todos ->
            View1.text = todos.toString()
         })*/

        button1 = rootView.findViewById(R.id.delete!!)as Button
        button1.setOnClickListener {
            db.userDao().deleteAll()
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun updateUserList(userList : List<User>){
        var userListText = "       Perfume List\n"

        for(i in userList){
            userListText += "\n name : ${i.name}, cost : ${i.cost}, scent : ${i.scent},  memo : ${i.memo}"
        }

        View1.text = userListText

    }
}