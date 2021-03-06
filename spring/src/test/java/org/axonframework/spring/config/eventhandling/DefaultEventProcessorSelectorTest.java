/*
 * Copyright (c) 2010-2012. Axon Framework
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

package org.axonframework.spring.config.eventhandling;

import org.axonframework.eventhandling.EventListener;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

/**
 * @author Allard Buijze
 */
public class DefaultEventProcessorSelectorTest {

    private DefaultEventProcessorSelector testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new DefaultEventProcessorSelector();
    }

    @Test
    public void testSameInstanceIsReturned() {
        String processor1 = testSubject.selectEventProcessor(mock(EventListener.class));
        String processor2 = testSubject.selectEventProcessor(mock(EventListener.class));
        String processor3 = testSubject.selectEventProcessor(mock(EventListener.class));

        assertSame(processor1, processor2);
        assertSame(processor2, processor3);
    }

    @Test
    public void testProvidedInstanceIsReturned() {
        String mock = "eventProcessor";
        testSubject = new DefaultEventProcessorSelector(mock);
        assertEquals(mock, testSubject.selectEventProcessor(mock(EventListener.class)));
    }
}
