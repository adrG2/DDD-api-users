package com.minderest.unit.util;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import com.minderest.shared.util.NestedNullCheck;
import com.minderest.user.domain.User;

public class NestedNullCheckTest {

    @Test
    public void testResolve() {

	User user = User.builder().id("1").firstName("Antonio").build();
	assertEquals(Optional.empty(), NestedNullCheck.resolve(() -> user.getLastName()));
	assertEquals(Optional.of("Antonio"), NestedNullCheck.resolve(() -> user.getFirstName()));
	assertEquals(Optional.of("1"), NestedNullCheck.resolve(() -> user.getId()));
    }

    @Test
    public void testResolveNull() {

	User user = null;
	assertEquals(Optional.empty(), NestedNullCheck.resolve(() -> user.getLastName()));
    }

}
