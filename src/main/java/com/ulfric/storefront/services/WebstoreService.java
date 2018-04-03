package com.ulfric.storefront.services;

import org.springframework.stereotype.Service;

import com.ulfric.storefront.model.Webstore;

@Service
public interface WebstoreService {

	Webstore getWebstore();

}
