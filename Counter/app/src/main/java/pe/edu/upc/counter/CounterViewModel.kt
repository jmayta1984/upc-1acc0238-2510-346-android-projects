package pe.edu.upc.counter

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    val count = mutableStateOf(0)

    fun increase(){
        count.value ++
    }
}