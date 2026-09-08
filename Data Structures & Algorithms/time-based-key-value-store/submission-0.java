class TimeMap {
    HashMap<String, List<int[]>> map; // key → [[timestamp, valueIndex]]
    HashMap<String, List<String>> vals;

    public TimeMap() {
        map = new HashMap<>();
        vals = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        vals.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new int[]{timestamp});
        vals.get(key).add(value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<int[]> times = map.get(key);
        List<String> values = vals.get(key);

        int left = 0, right = times.size() - 1;
        String result = "";

        while(left <= right){
            int mid = (left + right) / 2;
            if(times.get(mid)[0] <= timestamp){
                result = values.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}