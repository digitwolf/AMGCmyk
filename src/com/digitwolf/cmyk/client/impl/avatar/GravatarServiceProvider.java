package com.digitwolf.cmyk.client.impl.avatar;

import com.digitwolf.cmyk.client.service.AvatarService;

public class GravatarServiceProvider implements AvatarService {

	@Override
	public String getAvatarUrl(String userEmail) {
		return GravatarUrlBuilder.build(userEmail);
	}

}
