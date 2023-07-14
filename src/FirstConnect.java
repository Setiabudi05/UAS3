import org.json.JSONArray;
import org.json.JSONObject;
import Model.ResponModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        ConnectURI koneksisaya = new ConnectURI();
        URL myAddress = koneksisaya.buildURL("https://dummyjson.com/products/search?q=Laptop");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);

        // Decoding JSON
        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<ResponModel> responModel = new ArrayList<>();
        for (int i = 0; i < responseJSON.length(); i++) {
            ResponModel resModel = new ResponModel();
            JSONObject myJSONObject = responseJSON.getJSONObject(i);
            resModel.setMsg(myJSONObject.getString("message"));
            resModel.setStatus(myJSONObject.getString("status"));
            resModel.setComment(myJSONObject.getString("comment"));
            responModel.add(resModel);
        }

        System.out.println("Response Are: ");
        for (int ind = 0; ind < responModel.size(); ind++) {
            System.out.println("MESSAGE : " + responModel.get(ind).getMsg());
            System.out.println("STATUS : " + responModel.get(ind).getStatus());
            System.out.println("COMMENTS : " + responModel.get(ind).getComment());
        }
    }
}