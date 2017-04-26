package __PBO4__.generated;

import ej.wadapps.management.ActivitiesList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleActivator;

public class PBO4Activator implements BundleActivator {

	moc.lab.MyActivity moc__lab__MyActivity;

	@Override
	public void initialize() {
		this.moc__lab__MyActivity = new moc.lab.MyActivity();
	}

	@Override
	public void link() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.add(this.moc__lab__MyActivity);

	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.remove(this.moc__lab__MyActivity);

	}

}