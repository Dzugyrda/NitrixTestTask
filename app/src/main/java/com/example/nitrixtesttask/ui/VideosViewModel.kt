package com.example.nitrixtesttask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixtesttask.models.VideoResponse
import com.example.nitrixtesttask.repository.VideosRepository
import kotlinx.coroutines.launch

class VideosViewModel : ViewModel() {
    val videosRepository = VideosRepository()
    val viewState = MutableLiveData(
        VideosViewState(isLoading = true)
    )

    init {
        viewModelScope.launch {
            val videosResponseResult = videosRepository.getAllVideos()
            when {
                videosResponseResult.isSuccessful -> {
                    viewState.postValue(
                        VideosViewState(
                            videos = videosResponseResult.body(),
                            isSuccess = true
                        )
                    )
                }
                !videosResponseResult.isSuccessful -> {
                    viewState.postValue(
                        VideosViewState(isError = true)
                    )
                }
            }

        }
    }
}


//class StartViewModel : ViewModel() {
//    val repository = Repository()
//    val viewState = MutableLiveData(
//        StartViewState(isLoading = true)
//    )
//    val viewState1 = MutableLiveData<VideosScreenState>(VideosScreenState.CurrencyLoading)
//
//    init {
//        viewModelScope.launch {
//            val currencyApiResult = repository.()
//            when {
//                currencyApiResult.isSuccessful -> {
//
//                    viewState1.postValue(
//                        VideosScreenState.CurrenciesLoaded(
//                            videos = currencyApiResult.body()
//                        )
//                    )
//                }
//                !currencyApiResult.isSuccessful -> {
//                    viewState.postValue(
//                        VideosViewState(isError = true)
//                    )
//                    viewState1.postValue(
//                        VideosScreenState.CurrencyFailed
//                    )
//                }
//            }
//
//        }
//    }
//}

data class VideosViewState(
    val videos: VideoResponse? = null,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)

//sealed interface VideosScreenState {
//    object VideosLoading : VideosScreenState
//    object VideosFailed : VideosScreenState
//    data class VideosLoaded(val videos: VideoResponse?) : VideosScreenState
//}