package com.example.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// ------------------------ URI VERSIONING ------------------------ //

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Lola");

	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Dilan"));
	}
	// ------------------------ PARAMETER VERSIONING ------------------------ //

	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Lola");

	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Dilan"));
	}

	// ------------------------ HEADER VERSIONING ------------------------ //

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Lola");

	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Dilan"));
	}

	// ------------------------ ACCEPT HEADER VERSIONING ------------------------ //

	@GetMapping(value = "/person/produces", produces = "application/com.goxr3plus.company1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Lola");

	}

	@GetMapping(value = "/person/produces", produces = "application/com.goxr3plus.company2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Dilan"));
	}
}
