package com.hyeon.tflite.tfliteimageclassifier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    val perfume_DataArray : ArrayList<Perfumes> = ArrayList()
    lateinit var recyclerView1 : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_1, container, false)
        perfume_DataArray.add(Perfumes(R.drawable.diptyque_doson,"딥디크_도손","149,000원","튜베로즈 핑크페퍼"))
        perfume_DataArray.add(Perfumes(R.drawable.lelabo_santal,"르라보_상탈","144,410원","샌달우드 암브록산"))
        perfume_DataArray.add(Perfumes(R.drawable.maison_margiela,"마르지엘라_커피브레이크","51,880원","웜스파이시 머스크"))
        perfume_DataArray.add(Perfumes(R.drawable.byredo_gypsywater,"바이레도_집시워터","123,400원","소나무가지 오리스"))
        perfume_DataArray.add(Perfumes(R.drawable.chanel_bluede,"샤넬_블루 드","87,850원","시더우드 베티버"))
        perfume_DataArray.add(Perfumes(R.drawable.acqua_di_parma_mirto,"아쿠아디파르마_미르토","64,990원","바질 베르가못"))
        perfume_DataArray.add(Perfumes(R.drawable.hermes_un,"에르메스_운 자르뎅 수르닐","51,870원","자몽 캐롯 로터스"))
        perfume_DataArray.add(Perfumes(R.drawable.aesop_thesset,"이솝_테싯","137,950원","유자 베티버 바질"))
        perfume_DataArray.add(Perfumes(R.drawable.jomalone_neroli,"조말론_네롤리","78,910원","바질 삼나무 네롤리"))
        perfume_DataArray.add(Perfumes(R.drawable.johnbarbatos_artisan,"존바바토스_아티산 ","39,940원","화이트 아이리스 오렌지"))
        perfume_DataArray.add(Perfumes(R.drawable.creed_royalwater,"크리드_로얄워터 ","260,360원","버베나 레몬 바질"))
        perfume_DataArray.add(Perfumes(R.drawable.tomford_white,"톰포드_화이트 ","178,940원","스웨이드 머스크 앰버"))


        recyclerView1 = rootView.findViewById(R.id.perfume_list!!)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter = PerfumeAdapter(perfume_DataArray)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }
}