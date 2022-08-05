
# NitrixTestTask 

The application contains a list of videos/clips that can be viewed
The data is taken from the open API https://gist.github.com/jsturgis/3b19447b304616f18657?permalink_comment_id=3725183#file-gistfile1-txt
## Screenshots

![image](https://user-images.githubusercontent.com/90032028/183110244-f79124ed-6517-482a-8e2e-7dbf7a3aa6c3.png)
![image (1)](https://user-images.githubusercontent.com/90032028/183110214-eb0beefa-69db-45c8-a327-438132fe0965.png)

## Tech Stack

**Architecture**: MVVM

**Dependency**: Retrofit, Room, Coroutines, Glide, ExoPlayer, Hilt

The app is split to ui and repository. UI contains two screens and models for each.  Repository contains database where saved data and api service where data loaded. Everyone has their own model.
   

