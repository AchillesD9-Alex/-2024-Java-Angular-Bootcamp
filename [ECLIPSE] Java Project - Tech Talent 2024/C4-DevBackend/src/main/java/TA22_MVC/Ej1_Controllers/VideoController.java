package TA22_MVC.Ej1_Controllers;

import java.util.List;

import TA22_MVC.Ej1_Models.Video;

public class VideoController {
    public void addVideo(Video video) {
        video.addVideo();
    }

    public List<Video> getAllVideos() {
        return Video.getAllVideos();
    }

    public Video getVideoById(int id) {
        return Video.getVideoById(id);
    }

    public void updateVideo(Video video) {
        video.updateVideo();
    }

    public void deleteVideo(int id) {
        Video.deleteVideo(id);
    }
    
    public List<Integer> getAllVideoIds() {
        return Video.getAllVideoIds();
    }
}

