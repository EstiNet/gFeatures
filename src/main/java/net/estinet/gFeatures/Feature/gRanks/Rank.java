package net.estinet.gFeatures.Feature.gRanks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Rank {
    private String name, prefix;
    private List<String> people = new CopyOnWriteArrayList<>();
    HashSet<String> perms = new HashSet<>();
    private List<Rank> inherits = new ArrayList<>(); // parents
    private List<Rank> inheriteds = new ArrayList<>(); // children

    public Rank(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void addPerson(String UUID) {
        people.add(UUID);
    }

    public void addPerm(String perm) {
        if (!perm.equals("")) {
            perms.add(perm);
        }
    }

    public void addInherit(Rank inherit) {
        try {
            if (!inherit.equals("") && !inherits.contains(inherit)) {
                inherits.add(inherit);
            }
        } catch (Exception e) {
        }
    }

    public void addInherited(Rank inherited) {
        try {
            if (!inherited.equals("") && !inheriteds.contains(inherited)) {
                inheriteds.add(inherited);
            }
        } catch (Exception e) {
        }
    }

    public boolean removePerson(String UUID) {
        if (people.contains(UUID)) {
            people.remove(UUID);
            return true;
        }
        return false;
    }

    public boolean removePerm(String perm) {
        if (perms.contains(perm)) {
            perms.remove(perm);
            return true;
        }
        return false;
    }

    public void removeInherit(Rank inherit) {
        for (int iter = 0; iter < inherits.size(); iter++) {
            if (inherits.get(iter).getName().equals(inherit.getName())) {
                inherits.remove(iter);
            }
        }
    }

    public HashSet<String> getPerms() {
        return perms;
    }

    public List<String> getPersonList() {
        return people;
    }

    public List<Rank> getInheritList() {
        return inherits;
    }

    public List<Rank> getInherited() {
        return inheriteds;
    }

    public void setName(String newname) {
        name = newname;
    }

    public void setPrefix(String newprefix) {
        prefix = newprefix;
    }

    public void setPersonList(List<String> newlist) {
        people = newlist;
    }
}
