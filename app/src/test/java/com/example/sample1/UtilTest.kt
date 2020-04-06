package com.example.sample1

import org.junit.After
import org.junit.Before

import org.junit.Test
import org.assertj.core.api.Assertions.*

class UtilTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getVersionCode() {
        assertThat(Util.getVersionCode()).isEqualTo(1)
    }
    @Test
    fun getVersionName() {
        assertThat(Util.getVersionName()).isEqualTo("1.0")
    }
}