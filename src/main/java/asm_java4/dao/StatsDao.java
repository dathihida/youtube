package asm_java4.dao;

import java.util.List;

import asm_java4.dto.VideoLikedInfo;
import asm_java4.enity.User;

public interface StatsDao {
	
	List<VideoLikedInfo> findVideoLikedInfo();
}
