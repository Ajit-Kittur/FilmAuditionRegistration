package com.actingregistration.dao;

import java.sql.SQLException;
import java.util.List;

import com.actingregistration.entities.Video;

public interface VideoDao {
	
	public boolean saveVideo(Video video) throws ClassNotFoundException, SQLException;
	public Video getVideo(int actorId, int videoId) throws ClassNotFoundException, SQLException;
	public List<Video> getAllVideos(int actorId) throws ClassNotFoundException, SQLException;
}
