package com.ulfric.storefront.repositories.internal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ulfric.storefront.model.Session;
import com.ulfric.storefront.repositories.SessionRepository;
import com.ulfric.storefront.util.IdUtil;

@Repository
public class SessionRepositoryImpl implements SessionRepository { // TODO implement

	@Override
	public Session getById(String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Session session) {
		// TODO Auto-generated method stub
	}

	@Override
	public Session createNew() {
		Session session = new Session();
		List<Long> visitTimestamps = new ArrayList<>();
		visitTimestamps.add(System.currentTimeMillis());
		session.setVisitTimestamps(visitTimestamps);
		session.setCustomerId(IdUtil.generateUniqueId());
		session.setAnalyticsId(IdUtil.generateUniqueId());
		save(session);
		return session;
	}

}
