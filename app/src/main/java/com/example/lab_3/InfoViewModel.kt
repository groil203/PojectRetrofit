package com.example.lab_3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_3.api.ApiService
import com.example.lab_3.api.RetrofitInstance
import com.example.lab_3.model.Exercise
import kotlinx.coroutines.launch
import retrofit2.Response

class InfoViewModel: ViewModel() {

    val myInfoExercisesList : MutableLiveData<Response<Exercise>> = MutableLiveData()

    fun getListExercises(){
        viewModelScope.launch {
            val retrofit = RetrofitInstance.getRetrofitInstance()
            val api: ApiService = retrofit.create(ApiService::class.java)
            myInfoExercisesList.value = api.getExercises(RetrofitInstance.getPar())
        }
    }
}