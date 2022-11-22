import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(Security.getProviders())
                .flatMap(provider -> provider.getServices().stream())
                .filter(service -> service.getType().equals(MessageDigest.class.getSimpleName()))
                .map(Provider.Service::getAlgorithm)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}