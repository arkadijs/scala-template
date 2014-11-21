import java.io.IOException;
import java.nio.file.*;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class ScalaProj {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: ScalaProj <template-dir> <new-project-dir>");
            System.err.println("args length = " + args.length);
            int i = 0;
            for (String arg : args) {
                System.err.println("arg " + (i++) + " = " + arg);
            }
            System.exit(1);

        }
        String template = args[0];
        String project  = args[1];
        String pkg      = project.replaceAll("[_+-]", "").toLowerCase();

        FileSystem fs = FileSystems.getDefault();

        copy(fs.getPath(template), fs.getPath(project));

        String[] files = new String[] {
            "build.sbt",
            "pom.xml",
            "src/main/scala/package/Main.scala",
            "src/test/scala/package/test/Test.scala",
            "src/main/resources/log4j.properties",
            "src/test/resources/log4j.properties"
        };
        String cs = "UTF-8";
        for (String file : files) {
            String content = new String(Files.readAllBytes(fs.getPath(template, file)), cs);
            content = content.replaceAll("\\$project", project).replaceAll("\\$package", pkg);
            Files.write(fs.getPath(project, file), content.getBytes(cs), StandardOpenOption.TRUNCATE_EXISTING);
        }

        String[] dirs = new String[]{
                "src/main/scala/package",
                "src/test/scala/package"
        };
        for (String dir : dirs) {
            Path path = fs.getPath(project, dir);
            Files.move(path, path.resolveSibling(pkg));
        }
    }

    private static void copy(final Path source, final Path target) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (dir.toFile().getName().startsWith(".")) return FileVisitResult.SKIP_SUBTREE;
                Files.createDirectories(target.resolve(source.relativize(dir)));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!file.toFile().getName().toLowerCase().startsWith("scalaproj"))
                    Files.copy(file, target.resolve(source.relativize(file)));
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
