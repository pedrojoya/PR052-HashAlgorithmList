import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String hashAlgorithms = Arrays.stream(Security.getProviders())
                .flatMap(provider -> provider.getServices().stream())
                .filter(service -> service.getType().equals(MessageDigest.class.getSimpleName()))
                .map(Provider.Service::getAlgorithm)
                .collect(Collectors.joining(", "));
        System.out.printf("Hash algorithms: %s\n", hashAlgorithms);
    }
}