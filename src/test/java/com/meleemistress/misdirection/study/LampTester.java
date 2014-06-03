/** 
 * (C) Copyright 2014 Halloran Parry. All Rights Reserved
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.meleemistress.misdirection.study;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.meleemistress.misdirection.study.proxy.WallSocketInvocationHandler;

/**
 * @author hparry
 * 
 */
public class LampTester {

    @Test
    public void testTheLamps() {
        TheAttic attic = new TheAttic();
        attic.throwALampOnThePile(new SingleChristmasLight());
        attic.throwALampOnThePile(new VeryNarrowSpotLight());
        attic.throwALampOnThePile(new VeryNarrowSpotLight());

        attic.illuminate();
    }

    @Test
    public void testTheWallSocket() {
        WallSocketInvocationHandler handler = new WallSocketInvocationHandler();
        Lamp lamp = (Lamp) Proxy.newProxyInstance(Lamp.class.getClassLoader(),
                                                  new Class[] { Lamp.class },
                                                  handler);
        lamp.illuminate();
    }

}
