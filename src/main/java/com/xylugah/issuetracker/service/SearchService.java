package com.xylugah.issuetracker.service;

import com.xylugah.issuetracker.entity.util.SearchBody;

public interface SearchService {

	SearchBody getSearchBody();
	
	SearchBody SetSeachValue(String value);
}
