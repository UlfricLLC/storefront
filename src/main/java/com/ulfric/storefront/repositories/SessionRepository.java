package com.ulfric.storefront.repositories;

import com.ulfric.storefront.model.Session;

public interface SessionRepository {

	Session getById(String sessionId);

	void save(Session session);

	Session createNew();

}
