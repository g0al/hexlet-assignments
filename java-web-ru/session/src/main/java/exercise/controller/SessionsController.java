package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", model("page", page));
    }

    public static void login(Context ctx) {
        var currentUser = UsersRepository.findByName(ctx.formParam("name"));

        String currentUserName = currentUser
                .map(User::getName)
                .orElse("Ошибка");

        String currentUserPassword = currentUser
                .map(User::getPassword)
                .orElse("Ошибка");
        String currentUserEncryptedPassword = Security.encrypt(currentUserPassword);

        try {
            var name = ctx.formParamAsClass("name", String.class)
                        .check(value -> value.equals(currentUserName), "Wrong username or password")
                        .get();

            var password = ctx.formParamAsClass("password", String.class)
                        .check(value -> Security.encrypt(value).equals(currentUserPassword), "Wrong username or password")
                        .get();
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect(NamedRoutes.rootPath());
        } catch (ValidationException e) {
            var page = new LoginPage(currentUserName, "Wrong username or password");
            ctx.render("build.jte", model("page", page)).status(422);
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
}
