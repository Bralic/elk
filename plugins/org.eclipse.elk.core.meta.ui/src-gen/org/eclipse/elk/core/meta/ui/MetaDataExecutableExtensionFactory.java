/*******************************************************************************
 * Copyright (c) 2016 Kiel University and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Kiel University - initial API and implementation
 *******************************************************************************/
package org.eclipse.elk.core.meta.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.elk.core.meta.ui.internal.MetaActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MetaDataExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(MetaActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		MetaActivator activator = MetaActivator.getInstance();
		return activator != null ? activator.getInjector(MetaActivator.ORG_ECLIPSE_ELK_CORE_META_METADATA) : null;
	}

}
