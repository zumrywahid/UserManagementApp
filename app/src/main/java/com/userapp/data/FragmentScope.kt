package com.userapp.data

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target
import javax.inject.Scope

/**
 * Created on 7/7/18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class FragmentScoped
