/*******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    spoenemann - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.core.util;

import org.eclipse.elk.core.AbstractLayoutProvider;

/**
 * A generic factory for layout algorithms.
 */
public class AlgorithmFactory implements IFactory<AbstractLayoutProvider> {
    
    /** The class for which instances shall be created. */
    private final Class<? extends AbstractLayoutProvider> clazz;
    /** The parameter used for initialization of layout providers. */
    private final String parameter;
    
    /**
     * Creates an instance factory for the given layout provider class.
     * 
     * @param theclazz the class for which instances shall be created
     */
    public AlgorithmFactory(final Class<? extends AbstractLayoutProvider> theclazz) {
        this(theclazz, null);
    }
    
    /**
     * Creates an instance factory for the given layout provider class, initialized with a parameter.
     * 
     * @param theclazz the class for which instances shall be created
     * @param theparameter the parameter used for initialization of layout providers
     */
    public AlgorithmFactory(final Class<? extends AbstractLayoutProvider> theclazz, final String theparameter) {
        this.clazz = theclazz;
        this.parameter = theparameter;
    }
    
    /**
     * {@inheritDoc}
     */
    public AbstractLayoutProvider create() {
        try {
            AbstractLayoutProvider algorithm = clazz.newInstance();
            algorithm.initialize(parameter);
            return algorithm;
        } catch (InstantiationException exception) {
            throw new WrappedException(exception);
        } catch (IllegalAccessException exception) {
            throw new WrappedException(exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void destroy(final AbstractLayoutProvider obj) {
        obj.dispose();
    }

}
