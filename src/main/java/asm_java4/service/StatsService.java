package asm_java4.service;

import java.util.List;

import asm_java4.dto.VideoLikedInfo;

public interface StatsService {
	List<VideoLikedInfo> findVideoLikedInfo();
}
