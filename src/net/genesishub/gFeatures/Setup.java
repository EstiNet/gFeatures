package net.genesishub.gFeatures;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.bukkit.Bukkit;

public class Setup {
	Configs config;
	@SuppressWarnings({ })
	public void onSetup(){
		Package[] packs = Package.getPackages();
		for(Package pac : packs){
			if(pac.getName().startsWith("net.genesishub.gFeatures")){
				Bukkit.getLogger().info(pac.getName());
				Annotation[] ann = pac.getDeclaredAnnotations();
				for(Annotation annt : ann){
					if(annt.equals(Configs.class)){
						Method[] method = annt.getClass().getMethods();
						for(Method meth : method){
							Annotation[] annts = meth.getAnnotations();
								for(Annotation ants : annts){
									if(ants.equals(Configs.class)){
										try {
											meth.invoke(null, null);
										} catch (IllegalAccessException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (IllegalArgumentException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (InvocationTargetException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}
						}
					}
				}
			}
		}
			/*try {
				Class[] classes = getClasses("net.genesishub.gFeatures.Feature.Base");
			for(Class classs : classes){
				Method[] methods = classs.getClass().getMethods();
				Bukkit.getLogger().info(classs.getName());
			 	for (Method method : methods) {
				 Configs annos = method.getAnnotation(Configs.class);
				 Bukkit.getLogger().info(method.getName());
            			if (annos != null) {
                			try {
                				method.invoke(classs);
                				Bukkit.getLogger().info("FOUND!");
                			} catch (Exception e) {
                   				e.printStackTrace();
                			}
            			}
        			}
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
	}
	@SuppressWarnings("rawtypes")
	private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}
	@SuppressWarnings("rawtypes")
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
		}
}
